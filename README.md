# 🎉 Corona Management System 🎉

Welcome to the **Corona Management System**, a Java-based application designed to manage and track patient data related to COVID-19. This system allows you to add, update, remove, and view patient details efficiently.

## 📋 Features

1. **➕ Add Patient**: Enter and save patient details.
2. **✏️ Update Patient**: Modify existing patient details.
3. **❌ Remove Patient**: Delete patient records.
4. **🏙️ View Patients By City**: Display patients from a specific city.
5. **🏞️ View Patients By State**: Display patients from a specific state.
6. **🌐 View Patients By Country**: Display patients from a specific country.
7. **📑 View All Patients**: Display all patients in the system.
8. **🔍 Get Patient Details By ID**: Retrieve details of a specific patient using their ID.
9. **🚪 Exit**: Exit the application.

## 🚀 How to Use

1. **Run the Application**:
    
sh
    javac Main.java
    java Main

2. **Follow the Menu**:
    - Choose the desired operation by entering the corresponding number.
    - Follow the prompts to enter or modify patient details.

## 📂 Project Structure

plaintext
CoronaManagementSystem/
│
├── Main.java
├── Patient.java
└── README.md

## 🛠️ Code Overview

### Main.java

public class Main {
    public static void main(String[] args) {
        CoronaManagementSystem system = new CoronaManagementSystem();
        system.menu();
    }
}

### CoronaManagementSystem.java

Handles all the core functionalities like adding, updating, and retrieving patient details.

## 🌟 Key Functionalities

•	Add Patient: Enter patient’s name, age, city, state, and country.
•	Update Patient: Modify existing details based on the patient ID.
•	Remove Patient: Delete patient records using the patient ID.
•	View Patients: Retrieve patient details based on city, state, country, or view all.

## 👨‍💻 Author

	•	Soojal Kumar Gangooja - GitHub

Enjoy using the Corona Management System! Stay safe and healthy! 💪











