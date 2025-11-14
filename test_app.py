#!/usr/bin/env python
"""
Test script for the Appointment Manager
"""

from appointment_manager import AppointmentManager
import os

def test_appointment_manager():
    """Test basic appointment manager functionality"""
    print("Testing Appointment Manager...")
    print("-" * 50)

    # Remove existing test data
    if os.path.exists("appointments.json"):
        os.remove("appointments.json")

    # Create manager instance
    manager = AppointmentManager()
    print("✓ AppointmentManager initialized")

    # Test 1: Add appointments
    print("\nTest 1: Adding appointments...")
    assert manager.add_appointment("Jan", 15, "Team Meeting", 2), "Failed to add appointment 1"
    assert manager.add_appointment("Feb", 20, "Doctor Appointment", 1), "Failed to add appointment 2"
    assert manager.add_appointment("Jan", 15, "Lunch with Client", 1), "Failed to add appointment 3"
    print("✓ Added 3 appointments successfully")

    # Test 2: Get all appointments
    print("\nTest 2: Getting all appointments...")
    appointments = manager.get_all_appointments()
    assert len(appointments) == 3, f"Expected 3 appointments, got {len(appointments)}"
    print(f"✓ Retrieved {len(appointments)} appointments")

    # Test 3: Get appointments by month
    print("\nTest 3: Getting appointments by month...")
    jan_appointments = manager.get_appointments_by_month("Jan")
    assert len(jan_appointments) == 2, f"Expected 2 Jan appointments, got {len(jan_appointments)}"
    print(f"✓ Retrieved {len(jan_appointments)} January appointments")

    # Test 4: Get appointments by day
    print("\nTest 4: Getting appointments by day...")
    day_15_appointments = manager.get_appointments_by_day(15)
    assert len(day_15_appointments) == 2, f"Expected 2 appointments on day 15, got {len(day_15_appointments)}"
    print(f"✓ Retrieved {len(day_15_appointments)} appointments on day 15")

    # Test 5: Update appointment
    print("\nTest 5: Updating appointment...")
    assert manager.update_appointment("Jan", 15, "Team Meeting", "Updated Team Meeting", 3), "Failed to update appointment"
    updated = manager.get_appointment("Jan", 15, "Updated Team Meeting")
    assert updated is not None, "Updated appointment not found"
    assert updated['duration'] == 3, "Duration not updated correctly"
    print("✓ Appointment updated successfully")

    # Test 6: Delete appointment
    print("\nTest 6: Deleting appointment...")
    assert manager.delete_appointment("Feb", 20, "Doctor Appointment"), "Failed to delete appointment"
    remaining = manager.get_all_appointments()
    assert len(remaining) == 2, f"Expected 2 remaining appointments, got {len(remaining)}"
    print("✓ Appointment deleted successfully")

    # Test 7: Clear month
    print("\nTest 7: Clearing month...")
    assert manager.clear_month("Jan"), "Failed to clear month"
    remaining = manager.get_all_appointments()
    assert len(remaining) == 0, f"Expected 0 remaining appointments, got {len(remaining)}"
    print("✓ Month cleared successfully")

    # Display summary
    print("\n" + "=" * 50)
    print("All tests passed! ✓")
    print("=" * 50)

    # Sample appointments for demo
    print("\nAdding sample appointments for demo...")
    manager.add_appointment("Jan", 10, "New Year Planning Meeting", 2)
    manager.add_appointment("Jan", 15, "Project Kickoff", 3)
    manager.add_appointment("Feb", 5, "Client Presentation", 2)
    manager.add_appointment("Feb", 14, "Valentine's Day Lunch", 1)
    manager.add_appointment("Mar", 20, "Spring Planning Session", 4)
    manager.add_appointment("Apr", 1, "Q1 Review Meeting", 2)
    manager.add_appointment("May", 10, "Team Building Event", 5)
    manager.add_appointment("Jun", 15, "Mid-Year Review", 3)

    appointments = manager.get_all_appointments()
    print(f"✓ Added {len(appointments)} sample appointments for testing the web interface")

    print("\nAppointments in system:")
    print("-" * 50)
    for i, apt in enumerate(appointments, 1):
        print(f"{i}. {apt['month']} {apt['day']}: {apt['description']} ({apt['duration']}h)")

    print("\n" + "=" * 50)
    print("Setup complete! You can now run the web application:")
    print("  python app.py")
    print("Then visit: http://localhost:5000")
    print("=" * 50)

if __name__ == "__main__":
    test_appointment_manager()
