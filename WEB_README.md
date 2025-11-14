# Appointment Manager Web Interface

A modern, responsive web interface for managing appointments built with Flask and Bootstrap.

## Features

- **Dashboard**: View statistics and recent appointments at a glance
- **Add Appointments**: Create new appointments with month, day, description, and duration
- **Edit Appointments**: Update appointment details
- **Delete Appointments**: Remove individual appointments
- **View by Month**: Filter and view appointments by specific months
- **View by Day**: Filter and view appointments by specific days
- **Clear Month/Day**: Bulk delete all appointments for a month or day
- **Responsive Design**: Works seamlessly on desktop, tablet, and mobile devices
- **Modern UI**: Built with Bootstrap 5 for a clean, professional look

## Installation

1. **Install Python dependencies:**
   ```bash
   pip install -r requirements.txt
   ```

   Or using uv (as per project instructions):
   ```bash
   uv sync
   source .venv/bin/activate
   ```

2. **Run the application:**
   ```bash
   python app.py
   ```

   Or using uv:
   ```bash
   uv run app.py
   ```

3. **Access the web interface:**
   Open your browser and navigate to:
   ```
   http://localhost:5000
   ```

## Project Structure

```
.
├── app.py                      # Main Flask application
├── appointment_manager.py      # Backend logic for appointment management
├── requirements.txt            # Python dependencies
├── appointments.json           # Data persistence file (auto-created)
├── templates/                  # HTML templates
│   ├── base.html              # Base template with navigation
│   ├── index.html             # Dashboard
│   ├── appointments.html      # All appointments view
│   ├── add_appointment.html   # Add appointment form
│   ├── edit_appointment.html  # Edit appointment form
│   ├── month_view.html        # Month-specific view
│   └── day_view.html          # Day-specific view
└── static/                     # Static assets
    ├── css/
    │   └── style.css          # Custom styles
    └── js/
        └── script.js          # Custom JavaScript
```

## Usage

### Adding an Appointment

1. Click "New Appointment" button on the dashboard
2. Select a month from the dropdown
3. Select a day (1-30)
4. Enter a description
5. Specify duration in hours
6. Click "Add Appointment"

### Editing an Appointment

1. Find the appointment in any view
2. Click the "Edit" button (pencil icon)
3. Update the description or duration
4. Click "Update Appointment"

### Deleting an Appointment

1. Find the appointment you want to delete
2. Click the "Delete" button (trash icon)
3. Confirm the deletion

### Viewing by Month or Day

1. From the dashboard, click "View by Month" or "View by Day"
2. Select the desired month or day
3. View all appointments for that period

### Clearing Appointments

- **Clear Month**: In the month view, click "Clear Month" to remove all appointments for that month
- **Clear Day**: In the day view, click "Clear Day" to remove all appointments for that day

## API Endpoints

The application also provides REST API endpoints:

- `GET /api/appointments` - Get all appointments as JSON
- `GET /api/appointments/month/<month>` - Get appointments for a specific month

## Data Persistence

Appointments are stored in `appointments.json` file in the project root. The file is automatically created on first use and updated whenever appointments are modified.

## Technologies Used

- **Backend**: Flask (Python web framework)
- **Frontend**: Bootstrap 5, HTML5, CSS3, JavaScript
- **Icons**: Bootstrap Icons
- **Data Storage**: JSON file-based persistence

## Features in Detail

### Dashboard Statistics
- Total number of appointments
- Total hours across all appointments
- Number of active months

### Responsive Design
- Mobile-friendly navigation
- Adaptive layouts for different screen sizes
- Touch-friendly buttons and forms

### User Experience
- Flash messages for success/error feedback
- Confirmation dialogs for destructive actions
- Auto-dismissing alerts
- Smooth animations and transitions
- Form validation

## Troubleshooting

### Port Already in Use
If port 5000 is already in use, you can change it in `app.py`:
```python
app.run(debug=True, host='0.0.0.0', port=5001)
```

### Import Errors
Make sure all dependencies are installed:
```bash
pip install -r requirements.txt
```

### Template Not Found
Ensure the `templates/` directory exists and contains all HTML files.

## Development

To run in development mode with auto-reload:
```bash
export FLASK_ENV=development
python app.py
```

## Production Deployment

For production deployment, consider using:
- **Gunicorn** or **uWSGI** as the WSGI server
- **Nginx** as a reverse proxy
- Environment variables for configuration
- A proper database instead of JSON files

Example with Gunicorn:
```bash
pip install gunicorn
gunicorn -w 4 -b 0.0.0.0:5000 app:app
```

## Security Notes

- Change the `secret_key` in `app.py` before deploying to production
- Consider adding authentication for multi-user scenarios
- Use HTTPS in production
- Implement rate limiting for API endpoints
- Validate and sanitize all user inputs

## Future Enhancements

- User authentication and authorization
- Calendar view with visual date picker
- Export appointments to CSV/PDF
- Email notifications for appointments
- Search and filter functionality
- Recurring appointments
- Categories/tags for appointments
- Dark mode toggle

## License

This project is part of the AppointmentProgram repository.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
