<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@include file="./base.jsp"%>
    
    <!-- Add CSS for error messages -->
    <style>
        .error {
            color: red;
        }
    </style>
    
    <!-- Add jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <!-- Add jQuery validation script -->
    <script>
        $(document).ready(function() {
            $('form').submit(function() {
                var isValid = true;
                
                // Reset error messages
                $('.error').text('');
                
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
                
                // Validate languages
                var languages = $('#languages').val();
                if (!languages || languages.length === 0) {
                    $('#languagesError').text('At least one language must be selected');
                    isValid = false;
                }
                
                // Validate hobbies
                var hobbies = $('input[name="hobby"]:checked').length;
                if (hobbies === 0) {
                    $('#hobbyError').text('At least one hobby must be selected');
                    isValid = false;
                }
                
                // Validate country
                var country = $('#country').val().trim();
                if (country === '') {
                    $('#countryError').text('Country is required');
                    isValid = false;
                }
                
                // Validate gender
                var gender = $('input[name="gender"]:checked').length;
                if (gender === 0) {
                    $('#genderError').text('Gender is required');
                    isValid = false;
                }
                
                return isValid;
            });
        });
    </script>
</head>
<body>

    <div class="container mt-3">

        <h1>Registration Form</h1>
        <form action="RegistrationController" method="post">

            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="firstName">First Name</label> 
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter First Name">
                        <div class="error" id="firstNameError"></div>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="lastName">Last Name</label> 
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last Name">
                        <div class="error" id="lastNameError"></div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="email">Email</label> 
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email">
                        <div class="error" id="emailError"></div>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <label for="mobileNo">Mobile Number</label> 
                        <input type="tel" class="form-control" id="mobileNo" name="mobileNo" placeholder="Enter Mobile Number">
                        <div class="error" id="mobileError"></div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="password">Password</label> 
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                        <div class="error" id="passwordError"></div>
                    </div>
                </div>
                
              
                <div class="col">
                    <div class="form-group">
                        <label for="languages">Languages</label> 
                        <select multiple class="form-control" id="languages" name="languages">
                            <option value="English">English</option>
                            <option value="Spanish">Spanish</option>
                            <option value="French">French</option>
                            <option value="Hindi">Hindi</option>
                            <option value="Gujarati">Gujarati</option>
                        </select>
                        <div class="error" id="languagesError"></div>
                    </div>
                </div>
            </div>
            
            
            <!-- Image Upload 
             <label for="image">Image:</label>
    <input type="file" id="image" name="image" accept="image/*"><br><br>   
            -->
                      
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="hobby">Hobbies</label><br> 
                        <input type="checkbox" id="hobby1" name="hobby" value="Reading">
                        <label for="hobby1"> Reading</label><br>
                        <input type="checkbox" id="hobby2" name="hobby" value="Traveling">
                        <label for="hobby2"> Traveling</label><br>
                        <input type="checkbox" id="hobby3" name="hobby" value="Chess">
                        <label for="hobby3"> Chess</label><br>
                        <input type="checkbox" id="hobby4" name="hobby" value="Football">
                        <label for="hobby4"> Football</label><br>
                        <div class="error" id="hobbyError"></div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label for="country">Country</label> 
                        <select class="form-control" id="country" name="country">
                            <option value="US">United States</option>
                            <option value="UK">United Kingdom</option>
                            <option value="India">India</option>
                            <option value="Argentina">Argentina</option>
                            <option value="Germany">Germany</option>
                            <option value="Portugal">Portugal</option>
                        </select>
                        <div class="error" id="countryError"></div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label>Gender</label><br> 
                        <input type="radio" id="Male" name="gender" value="Male">
                        <label for="Male"> Male</label><br>
                        <input type="radio" id="Female" name="gender" value="Female">
                        <label for="Female"> Female</label><br>
                        <div class="error" id="genderError"></div>
                    </div>
                </div>
            </div>

            <a href="${pageContext.request.contextPath }/" class="btn btn-warning"> Back </a>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    </div>
  
</body>
</html>
