# Quick Start Guide - Appointment Manager Web Interface

## Get Started in 3 Steps

### 1. Install Dependencies

```bash
pip install -r requirements.txt
```

Or using uv (recommended):
```bash
uv sync
source .venv/bin/activate
```

### 2. Run the Application

```bash
python app.py
```

Or using uv:
```bash
uv run app.py
```

### 3. Open Your Browser

Visit: **http://localhost:5000**

## What You'll See

- **Dashboard**: Overview with statistics and recent appointments
- **Add Appointment**: Click the green "New Appointment" button
- **View by Month/Day**: Use the quick actions to filter appointments
- **Edit/Delete**: Use the action buttons on each appointment

## Testing the Application

Run the test script to verify everything works and populate sample data:

```bash
python test_app.py
```

This will:
- Run automated tests
- Create sample appointments
- Verify all functionality

## Features Available

✓ Create new appointments
✓ Edit existing appointments
✓ Delete appointments
✓ View by month or day
✓ Dashboard statistics
✓ Responsive mobile design
✓ REST API endpoints

## Need Help?

See `WEB_README.md` for complete documentation.

## Screenshots

### Dashboard
The main dashboard shows:
- Total appointments count
- Total hours scheduled
- Active months
- Recent appointments list

### Add/Edit Forms
Simple forms with:
- Month and day selection
- Description text area
- Duration input

### Filtered Views
- Month view: See all appointments for a specific month
- Day view: See all appointments across months for a specific day

## API Endpoints

For developers:
- `GET /api/appointments` - All appointments as JSON
- `GET /api/appointments/month/<month>` - Month-specific appointments

## File Structure

```
├── app.py                    # Flask application
├── appointment_manager.py    # Backend logic
├── requirements.txt          # Dependencies
├── templates/                # HTML templates
├── static/                   # CSS & JS
└── appointments.json         # Data file (auto-created)
```

Enjoy managing your appointments! 🎉
