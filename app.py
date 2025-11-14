from flask import Flask, render_template, request, redirect, url_for, flash, jsonify
from appointment_manager import AppointmentManager
from datetime import datetime

app = Flask(__name__)
app.secret_key = 'your-secret-key-here-change-in-production'

# Initialize the appointment manager
manager = AppointmentManager()

@app.route('/')
def index():
    """Display the main dashboard with all appointments"""
    appointments = manager.get_all_appointments()
    return render_template('index.html', appointments=appointments)

@app.route('/appointments')
def view_appointments():
    """View all appointments"""
    appointments = manager.get_all_appointments()
    return render_template('appointments.html', appointments=appointments)

@app.route('/appointments/month/<month>')
def view_month(month):
    """View appointments for a specific month"""
    appointments = manager.get_appointments_by_month(month)
    return render_template('month_view.html', month=month, appointments=appointments)

@app.route('/appointments/day/<int:day>')
def view_day(day):
    """View appointments for a specific day"""
    appointments = manager.get_appointments_by_day(day)
    return render_template('day_view.html', day=day, appointments=appointments)

@app.route('/appointments/add', methods=['GET', 'POST'])
def add_appointment():
    """Add a new appointment"""
    if request.method == 'POST':
        month = request.form.get('month')
        day = int(request.form.get('day'))
        description = request.form.get('description')
        duration = int(request.form.get('duration'))

        success = manager.add_appointment(month, day, description, duration)

        if success:
            flash('Appointment added successfully!', 'success')
            return redirect(url_for('index'))
        else:
            flash('Failed to add appointment. Please try again.', 'error')

    return render_template('add_appointment.html', months=manager.get_months(), days=manager.get_days())

@app.route('/appointments/edit/<month>/<int:day>/<description>', methods=['GET', 'POST'])
def edit_appointment(month, day, description):
    """Edit an existing appointment"""
    if request.method == 'POST':
        new_description = request.form.get('description')
        new_duration = int(request.form.get('duration'))

        success = manager.update_appointment(month, day, description, new_description, new_duration)

        if success:
            flash('Appointment updated successfully!', 'success')
            return redirect(url_for('index'))
        else:
            flash('Failed to update appointment. Please try again.', 'error')

    appointment = manager.get_appointment(month, day, description)
    return render_template('edit_appointment.html',
                         appointment=appointment,
                         months=manager.get_months(),
                         days=manager.get_days())

@app.route('/appointments/delete/<month>/<int:day>/<description>', methods=['POST'])
def delete_appointment(month, day, description):
    """Delete an appointment"""
    success = manager.delete_appointment(month, day, description)

    if success:
        flash('Appointment deleted successfully!', 'success')
    else:
        flash('Failed to delete appointment. Please try again.', 'error')

    return redirect(url_for('index'))

@app.route('/appointments/clear/month/<month>', methods=['POST'])
def clear_month(month):
    """Clear all appointments for a specific month"""
    success = manager.clear_month(month)

    if success:
        flash(f'All appointments for {month} have been cleared!', 'success')
    else:
        flash('Failed to clear month. Please try again.', 'error')

    return redirect(url_for('index'))

@app.route('/appointments/clear/day/<int:day>', methods=['POST'])
def clear_day(day):
    """Clear all appointments for a specific day"""
    success = manager.clear_day(day)

    if success:
        flash(f'All appointments for day {day} have been cleared!', 'success')
    else:
        flash('Failed to clear day. Please try again.', 'error')

    return redirect(url_for('index'))

@app.route('/api/appointments')
def api_appointments():
    """API endpoint to get all appointments as JSON"""
    appointments = manager.get_all_appointments()
    return jsonify(appointments)

@app.route('/api/appointments/month/<month>')
def api_month_appointments(month):
    """API endpoint to get appointments for a specific month"""
    appointments = manager.get_appointments_by_month(month)
    return jsonify(appointments)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
