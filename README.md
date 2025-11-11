# Diary/Appointment Program

A Java-based appointment management system with a graphical user interface for storing, managing, and persisting appointments.

## Features

- Store, update, and delete appointments
- GUI-based interface for easy interaction
- Data persistence using Java serialization
- Sparse table data structure for efficient appointment storage
- Appointments are preserved even after program closure

## Technology Stack

- **Language**: Java
- **Data Structure**: Sparse table
- **Persistence**: Java serialization
- **IDE**: NetBeans/Eclipse compatible

## Project Structure

```
diary/
├── src/
│   └── diary/
│       ├── Diary.java          # Main class - program entry point
│       ├── DiaryFrame.java     # GUI frame
│       ├── DairyFrame.java     # Additional frame component
│       ├── Appointment.java    # Appointment model
│       └── Calendar.java       # Calendar utilities
├── build/
├── dist/
└── nbproject/
```

## Running the Application

1. Open the project in NetBeans or Eclipse
2. Build the project to compile all `.java` files
3. Run the main class located in `Diary.java` (diary/src/diary/Diary.java)
4. The GUI will launch, allowing you to manage appointments

## Persistence

The application uses serialization to save appointments to `Object.txt`, ensuring data persistence across sessions.

## Contributing

Contributions are welcome! Please feel free to:
- Report bugs or issues
- Suggest new features
- Submit pull requests
- Provide feedback on code improvements

## License

This project is open source and available for educational purposes.

## Repository History

- Initial commit: Java Diary Program with basic appointment management
- Added: GUI interface for the Diary application
- Project continues to be maintained and improved

## Notes

- The main entry point is the `Diary` class
- Appointments are serialized and saved automatically
- Compatible with NetBeans and Eclipse IDEs

## Contact

For questions, issues, or collaboration opportunities, please open an issue on GitHub.
