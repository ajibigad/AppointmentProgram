import json
import os
from datetime import datetime
from typing import List, Dict, Optional

class AppointmentManager:
    """Manager class for handling appointment operations with JSON persistence"""

    MONTHS = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"]
    DAYS = list(range(1, 31))
    DATA_FILE = "appointments.json"

    def __init__(self):
        """Initialize the appointment manager and load existing appointments"""
        self.appointments = self._load_appointments()

    def _load_appointments(self) -> List[Dict]:
        """Load appointments from JSON file"""
        if os.path.exists(self.DATA_FILE):
            try:
                with open(self.DATA_FILE, 'r') as f:
                    return json.load(f)
            except (json.JSONDecodeError, IOError):
                return []
        return []

    def _save_appointments(self) -> bool:
        """Save appointments to JSON file"""
        try:
            with open(self.DATA_FILE, 'w') as f:
                json.dump(self.appointments, f, indent=2)
            return True
        except IOError:
            return False

    def add_appointment(self, month: str, day: int, description: str, duration: int) -> bool:
        """Add a new appointment"""
        if not self._validate_date(month, day):
            return False

        appointment = {
            "month": month.capitalize(),
            "day": day,
            "description": description,
            "duration": duration,
            "created_at": datetime.now().isoformat()
        }

        self.appointments.append(appointment)
        return self._save_appointments()

    def delete_appointment(self, month: str, day: int, description: str) -> bool:
        """Delete an appointment by month, day, and description"""
        original_length = len(self.appointments)

        self.appointments = [
            app for app in self.appointments
            if not (app['month'].lower() == month.lower() and
                   app['day'] == day and
                   app['description'] == description)
        ]

        if len(self.appointments) < original_length:
            return self._save_appointments()
        return False

    def update_appointment(self, month: str, day: int, old_description: str,
                          new_description: str, new_duration: int) -> bool:
        """Update an existing appointment"""
        for app in self.appointments:
            if (app['month'].lower() == month.lower() and
                app['day'] == day and
                app['description'] == old_description):

                app['description'] = new_description
                app['duration'] = new_duration
                return self._save_appointments()
        return False

    def get_appointment(self, month: str, day: int, description: str) -> Optional[Dict]:
        """Get a specific appointment"""
        for app in self.appointments:
            if (app['month'].lower() == month.lower() and
                app['day'] == day and
                app['description'] == description):
                return app
        return None

    def get_all_appointments(self) -> List[Dict]:
        """Get all appointments sorted by month and day"""
        return sorted(self.appointments,
                     key=lambda x: (self._month_to_index(x['month']), x['day']))

    def get_appointments_by_month(self, month: str) -> List[Dict]:
        """Get all appointments for a specific month"""
        return [
            app for app in self.appointments
            if app['month'].lower() == month.lower()
        ]

    def get_appointments_by_day(self, day: int) -> List[Dict]:
        """Get all appointments for a specific day across all months"""
        return [
            app for app in self.appointments
            if app['day'] == day
        ]

    def clear_month(self, month: str) -> bool:
        """Clear all appointments for a specific month"""
        original_length = len(self.appointments)

        self.appointments = [
            app for app in self.appointments
            if app['month'].lower() != month.lower()
        ]

        if len(self.appointments) < original_length:
            return self._save_appointments()
        return True  # No appointments to clear

    def clear_day(self, day: int) -> bool:
        """Clear all appointments for a specific day"""
        original_length = len(self.appointments)

        self.appointments = [
            app for app in self.appointments
            if app['day'] != day
        ]

        if len(self.appointments) < original_length:
            return self._save_appointments()
        return True  # No appointments to clear

    def clear_all(self) -> bool:
        """Clear all appointments"""
        self.appointments = []
        return self._save_appointments()

    def get_months(self) -> List[str]:
        """Get list of all months"""
        return self.MONTHS

    def get_days(self) -> List[int]:
        """Get list of all days"""
        return self.DAYS

    def _validate_date(self, month: str, day: int) -> bool:
        """Validate month and day"""
        if month.capitalize() not in self.MONTHS:
            return False
        if day < 1 or day > 30:
            return False
        return True

    def _month_to_index(self, month: str) -> int:
        """Convert month name to index for sorting"""
        try:
            return self.MONTHS.index(month.capitalize())
        except ValueError:
            return 0

    def get_calendar_view(self) -> Dict[str, List[Dict]]:
        """Get appointments organized by month for calendar view"""
        calendar = {month: [] for month in self.MONTHS}

        for app in self.appointments:
            month = app['month']
            if month in calendar:
                calendar[month].append(app)

        # Sort appointments within each month by day
        for month in calendar:
            calendar[month].sort(key=lambda x: x['day'])

        return calendar
