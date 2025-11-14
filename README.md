# Appointment Program

A Java-based appointment diary application with a graphical user interface (GUI) for managing appointments and schedules.

## Overview

This program serves as a digital diary for storing, managing, and organizing appointments. It provides a user-friendly GUI interface for easy interaction and uses serialization to persist data between sessions.

## Features

- **Appointment Management**: Create, update, and delete appointments
- **Data Persistence**: Uses Java serialization to store appointments permanently
- **GUI Interface**: Easy-to-use graphical interface for managing your schedule
- **Sparse Table Data Structure**: Efficient storage mechanism for appointments
- **Session Persistence**: Appointments are retained even after the program is closed

## Project Structure

```
diary/
├── src/
│   └── diary/
│       ├── Diary.java          # Main entry point
│       ├── DiaryFrame.java     # GUI implementation
│       ├── DairyFrame.java     # Additional GUI component
│       ├── Appointment.java    # Appointment data model
│       └── Calendar.java       # Calendar functionality
├── build/                      # Compiled classes
└── dist/                       # Distribution files
```

## Requirements

- Java Development Kit (JDK) 8 or higher
- NetBeans IDE or Eclipse (recommended for development)

## Setup and Installation

### Using NetBeans

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Open NetBeans IDE

3. Go to `File` → `Open Project`

4. Navigate to the `diary` folder and select it

5. NetBeans will automatically recognize it as a Java project

### Using Eclipse

1. Clone the repository

2. Open Eclipse IDE

3. Go to `File` → `Import` → `Existing Projects into Workspace`

4. Select the `diary` folder as the root directory

5. Click `Finish`

### Manual Compilation

If you prefer to compile manually:

```bash
cd diary/src
javac diary/*.java
java diary.Diary
```

## Running the Application

The main entry point is in the `Diary.java` class.

- **In NetBeans/Eclipse**: Right-click on `Diary.java` and select "Run File"
- **From command line**: Navigate to the build directory and run `java diary.Diary`

## Additional Projects

This repository also contains:

- **Spam_SMS_detector.ipynb**: A Jupyter notebook for spam SMS detection using machine learning

## Usage

1. Launch the application by running the `Diary` class
2. The GUI window will appear
3. Use the interface to:
   - Add new appointments with date and time
   - View existing appointments
   - Update appointment details
   - Delete appointments you no longer need

## Data Storage

Appointments are stored using Java serialization in the `Object.txt` file. This ensures that your data persists between application sessions.

## Contributing

Contributions are welcome! If you'd like to contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

## Issues and Support

If you encounter any issues or have questions:

1. Check the [Issues](../../issues) page to see if your problem has been reported
2. If not, create a new issue with a detailed description
3. Include steps to reproduce the problem if applicable

## License

Please refer to the LICENSE file in the repository for licensing information.

## Acknowledgments

This project serves as a foundation for appointment management with basic CRUD (Create, Read, Update, Delete) operations. Future enhancements could include:

- Advanced search and filtering capabilities
- Reminder notifications
- Calendar view integration
- Export/import functionality
- Cloud synchronization

---

**Note**: This is an educational project demonstrating Java GUI programming, data structures, and object serialization techniques.
