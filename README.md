# Multi-Project Repository

This repository contains two distinct projects: a Diary/Appointment Management application and a Spam SMS Detector using Natural Language Processing.

---

## 1. Diary/Appointment Program

A Java-based appointment management system with a graphical user interface for storing, managing, and persisting appointments.

### Features

- Store, update, and delete appointments
- GUI-based interface for easy interaction
- Data persistence using Java serialization
- Sparse table data structure for efficient appointment storage
- Appointments are preserved even after program closure

### Technology Stack

- **Language**: Java
- **Data Structure**: Sparse table
- **Persistence**: Java serialization
- **IDE**: NetBeans/Eclipse compatible

### Project Structure

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

### Running the Diary Application

1. Open the project in NetBeans or Eclipse
2. Build the project to compile all `.java` files
3. Run the main class located in `Diary.java` (diary/src/diary/Diary.java)
4. The GUI will launch, allowing you to manage appointments

### Persistence

The application uses serialization to save appointments to `Object.txt`, ensuring data persistence across sessions.

---

## 2. Spam SMS Detector

A machine learning project that uses Natural Language Processing to classify SMS messages as spam or legitimate (ham).

### Features

- Text preprocessing and tokenization using spaCy
- Language model fine-tuning with AWD-LSTM architecture
- Text classification using fastai
- Training on Kaggle SMS spam dataset
- High accuracy spam detection

### Technology Stack

- **Language**: Python
- **Framework**: fastai (PyTorch-based)
- **NLP**: spaCy, fastai.text
- **Model**: AWD-LSTM (ASGD Weight-Dropped LSTM)
- **Dataset**: [Spam SMS Classification dataset from Kaggle](https://www.kaggle.com/datasets/mariumfaheem666/spam-sms-classification-using-nlp/data)

### Model Architecture

1. **Language Model Training**: Fine-tunes a language model on SMS text data to learn domain-specific patterns
2. **Text Classification**: Uses the fine-tuned encoder to classify messages as spam or ham

### Running the Spam Detector

#### Option 1: Google Colab (Recommended)

[![Open In Colab](https://colab.research.google.com/assets/colab-badge.svg)](https://colab.research.google.com/github/ajibigad/AppointmentProgram/blob/master/Spam_SMS_detector.ipynb)

Click the badge above to open the notebook in Google Colab and run it with free GPU access.

#### Option 2: Local Environment

1. **Install dependencies**:
   ```bash
   pip install fastai kagglehub spacy
   python -m spacy download en_core_web_sm
   ```

2. **Run the notebook**:
   ```bash
   jupyter notebook Spam_SMS_detector.ipynb
   ```

### Dataset

The project uses the Spam SMS dataset which contains 5,574 messages labeled as either 'spam' or 'ham' (legitimate). The dataset is automatically downloaded using kagglehub.

### Model Performance

The model achieves high accuracy in detecting spam messages through:
- Fine-tuning on SMS-specific language patterns
- Multi-stage training with gradual unfreezing
- Dropout regularization to prevent overfitting

### Example Usage

```python
learn.predict("Congratulations! You've won a $1,000 Walmart gift card. Go to http://bit.ly/123456 to claim now.")
# Output: ('spam', tensor(1), tensor([0.0045, 0.9955]))
```

---

## Contributing

Contributions to either project are welcome! Please feel free to:
- Report bugs or issues
- Suggest new features
- Submit pull requests
- Provide feedback on code improvements

## License

This project is open source and available for educational purposes.

## Repository History

- Initial commit: Java Diary Program with basic appointment management
- Added: GUI interface for the Diary application
- Added: Spam SMS Detector notebook with NLP-based classification
- Project continues to be maintained and improved

---

## Notes

### For the Diary Application
- The main entry point is the `Diary` class
- Appointments are serialized and saved automatically
- Compatible with NetBeans and Eclipse IDEs

### For the Spam Detector
- Requires GPU for faster training (available free in Google Colab)
- Training data is downloaded automatically via kagglehub
- Model uses transfer learning from pre-trained language models

## Contact

For questions, issues, or collaboration opportunities, please open an issue on GitHub.
