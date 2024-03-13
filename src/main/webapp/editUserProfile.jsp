<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Your Profile</title>
    <!-- Include jQuery library -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 400px;
            max-height: 70%;
            overflow-y: auto; /* Add scrollbar if content exceeds the height */
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
            margin-top: 0; /* Remove default top margin */
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        input[type="text"],
        input[type="password"],
        select {
            width: calc(100% - 10px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="file"] {
            width: calc(100% - 10px);
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        select {
            width: 100%;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Validation error style */
        .error {
            border: 1px solid red;
        }

        .error-message {
            color: red;
            margin-top: -5px;
            margin-bottom: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="contact-form bg-light p-30">
    <form id="editProfileForm" action="${pageContext.request.contextPath}/editUserProfile" method="post" enctype="multipart/form-data">
        <h2>Edit Your Profile</h2>
        <!-- Hidden field to store the user ID -->
        <input type="hidden" id="userId" name="userId" value="${user.userId}">


        <!-- Add input fields for user details -->
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" value="${user.firstName}"><span class="error-message" id="firstNameError"></span>

        <label for="lastName">Last Name:</label>
        <input type="text" name="lastName" id="lastName" value="${user.lastName}"><span class="error-message" id="lastNameError"></span>

        <label for="gender">Gender:</label>
        <select name="gender" id="gender">
            <option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
            <option value="Female" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
        </select>

        <label for="email">Email:</label>
        <input type="text" name="email" id="email" value="${user.email}" ><span class="error-message" id="emailError"></span>

        <label for="mobileNo">Mobile:</label>
        <input type="text" name="mobileNo" id="mobileNo" value="${user.mobileNo}"><span class="error-message" id="mobileError"></span>

        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value="${user.password}"><span class="error-message" id="passwordError"></span>

        <!-- Languages -->
        <div class="col-md-12">
            <label class="labels">Languages:</label>
            <div class="languages-options">
                <select id="languages" name="languages" multiple>
                    <option value="English" ${user.languages.contains('English') ? 'selected' : ''}>English</option>
                    <option value="Spanish" ${user.languages.contains('Spanish') ? 'selected' : ''}>Spanish</option>
                    <option value="Hindi" ${user.languages.contains('Hindi') ? 'selected' : ''}>Hindi</option>
                    <option value="Gujarati" ${user.languages.contains('Gujarati') ? 'selected' : ''}>Gujarati</option>
                    <option value="French" ${user.languages.contains('French') ? 'selected' : ''}>French</option>
                </select>
            </div>
        </div>

        <!-- Hobbies -->
        <div class="col-md-12">
            <label class="labels">Hobbies:</label>
            <div class="hobbies-options">
                <label>Reading <input type="checkbox" name="hobby" value="Reading" ${user.hobby.contains('Reading') ? 'checked' : ''}></label>
                <label>Traveling <input type="checkbox" name="hobby" value="Traveling" ${user.hobby.contains('Traveling') ? 'checked' : ''}></label>
                <label>Chess <input type="checkbox" name="hobby" value="Chess" ${user.hobby.contains('Chess') ? 'checked' : ''}></label>
                <label>Football <input type="checkbox" name="hobby" value="Football" ${user.hobby.contains('Football') ? 'checked' : ''}></label>
            </div>
        </div>

        <!-- Country -->
        <label for="country">Country:</label>
        <select name="country" id="country">
            <option value="us" ${user.country.equals("us") ? 'selected' : ''}>United States</option>
            <option value="uk" ${user.country.equals("uk") ? 'selected' : ''}>United Kingdom</option>
            <option value="in" ${user.country.equals("in") ? 'selected' : ''}>India</option>
        </select>
        

        <input type="submit" value="Save Changes">
    </form>
</div>


</body>
</html>
