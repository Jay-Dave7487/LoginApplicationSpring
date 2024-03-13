<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    
    <!-- Add jQuery -->
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

        .edit-form {
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            max-width: 350px;
            width: 100%;
            max-height: 80vh;
            overflow-y: auto;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"],
        input[type="password"],
        select {
            width: calc(100% - 22px);
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        select[multiple] {
            height: 100px;
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
            display: inline-block;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            margin-top: -5px;
            margin-bottom: 5px;
            font-size: 14px;
        }
    </style>
    
    <!-- Add CSS for error messages -->
    <style>
        .error {
            color: red;
        }
    </style>
    
    <!-- jQuery validation script -->
    <script>
        $(document).ready(function() {
            $('.edit-form').submit(function() {
                var isValid = true;
                
                // Reset error messages
                $('.error-message').text('');
                
                // Validate first name
                var firstName = $('#firstName').val().trim();
                if (firstName === '') {
                    $('#firstNameError').text('First name is required');
                    isValid = false;
                }
                
                // Validate last name
                var lastName = $('#lastName').val().trim();
                if (lastName === '') {
                    $('#lastNameError').text('Last name is required');
                    isValid = false;
                }
                
                // Validate email
                var email = $('#email').val().trim();
                if (email === '') {
                    $('#emailError').text('Email is required');
                    isValid = false;
                }
                
                // Validate mobile number
                var mobileNo = $('#mobileNo').val().trim();
                if (mobileNo === '') {
                    $('#mobileError').text('Mobile number is required');
                    isValid = false;
                }
                
                // Validate password
                var password = $('#password').val().trim();
                if (password === '') {
                    $('#passwordError').text('Password is required');
                    isValid = false;
                }
             // Validate hobbies
                var hobbies = $('input[name="hobby"]:checked').length;
                if (hobbies === 0) {
                    $('#hobbyError').text('At least one hobby must be selected');
                    isValid = false;
                }
                
             // Validate languages
                var languages = $('#languages').val();
                if (!languages || languages.length === 0) {
                    $('#languagesError').text('At least one language must be selected');
                    isValid = false;
                }
                
                return isValid;
            });
        });
    </script>
</head>
<body>

<div class="edit-form">
    <h2>Edit User</h2>
    <form id="editForm" action="editUserUpdate" method="post" >
    <!-- Hidden field to store the action -->
  <input type="hidden" name="userId" value="${user.userId}"/>
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
            <div class="error" id="hobbyError"></div>
            </div>
        </div>

           <!-- Country -->
        <label for="country">Country:</label>
        <select name="country" id="country">
            <option value="US" ${user.country.equals("US") ? 'selected' : ''}>United States</option>
            <option value="UK" ${user.country.equals("UK") ? 'selected' : ''}>United Kingdom</option>
            <option value="India" ${user.country.equals("India") ? 'selected' : ''}>India</option>
            <option value="Argentina" ${user.country.equals("Argentina") ? 'selected' : ''}>Argentina</option>
            <option value="Germany" ${user.country.equals("Germany") ? 'selected' : ''}>Germany</option>
            <option value="Portugal" ${user.country.equals("Portugal") ? 'selected' : ''}>Portugal</option>
        </select>

        <input type="submit" value="Save Changes">
    </form>
</div>

</body>
</html>
