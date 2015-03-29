<%@include file="parts/header.jsp"%>
<html>
    <!-- HEAD block-->
    <%@include file="parts/head.jsp"%>
    <!-- HEAD block-->
    <body>
        <div class="wrapper">
            <div class="header"></div>
            <div class="main">
                <div ID = "enter">
                    <div ID="regForm">

                        <!--<form action="#" ID="newRegForm">
                            <label>
                                <span>${SITE_CONTENT[NAME]}</span>
                                <input type="text" name="name" placeholder = "Enter your name" required>
                            </label>
                            <label>
                                <span>${SITE_CONTENT[LAST_NAME]}</span>
                                <input type="text" name="lastName" placeholder = "Enter your last name" required>
                            </label>
                            <label>
                                <span>${SITE_CONTENT[NATIVE_LANGUAGE]}</span>
                                <select>
                                    <option value="french">English</option>
                                    <option value="russian">Russian</option>
                                    <option value="french">French</option>
                                </select>
                            </label>
                            <label>
                                <span>${SITE_CONTENT[EMAIL]}</span>
                                <input type="email" name="email" placeholder = "Enter your email" required>
                            </label>
                            <label>
                                <span>${SITE_CONTENT[LOGIN]}</span>
                                <input type="text" name="login" placeholder = "Enter your login" required>
                            </label>
                            <label>
                                <span>${SITE_CONTENT[PASSWORD]}</span>
                                <input type="password" name="pass" placeholder = "Enter password" required>
                            </label>
                            <label>
                                <span>${SITE_CONTENT[REPEATED_PASSWORD]}</span>
                                <input type="password" name="passRep" placeholder = "Repeat password" required>
                            </label>
                            <input type="submit" name="submit" value="${SITE_CONTENT[CREATE]}"/>
                            <input type="button" onclick="" name="back" value="Back"/>
                        </form>-->

                        <form:form method="POST" commandName="user" action="registerUser">
                           <table>
                            <tr>
                                <td><form:label path="name">${SITE_CONTENT[NAME]}</form:label></td>
                                <td><form:input path="name" /></td>
                                <td style="color:red"><form:errors path="name" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="lastName">${SITE_CONTENT[LAST_NAME]}</form:label></td>
                                <td><form:input path="lastName" /></td>
                                <td style="color:red"><form:errors path="lastName" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="nativeLanguage">${SITE_CONTENT[NATIVE_LANGUAGE]}</form:label></td>
                                <td><form:select path="nativeLanguage" items="${languages}" /></td>
                                <td style="color:red"><form:errors path="nativeLanguage" /></td>
                            </tr>
                               <tr>
                                   <td><form:label path="email">${SITE_CONTENT[EMAIL]}</form:label></td>
                                   <td><form:input path="email" /></td>
                                   <td style="color:red"><form:errors path="email" /></td>
                               </tr>
                            <tr>
                                <td><form:label path="login">${SITE_CONTENT[LOGIN]}</form:label></td>
                                <td><form:input path="login" /></td>
                                <td style="color:red"><form:errors path="login" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="password">${SITE_CONTENT[PASSWORD]}</form:label></td>
                                <td><form:input path="password" /></td>
                                <td style="color:red"><form:errors path="password" /></td>
                            </tr>
                            <tr>
                                <td><form:label path="repeatedPassword">${SITE_CONTENT[REPEATED_PASSWORD]}</form:label></td>
                                <td><form:input path="repeatedPassword" /></td>
                                <td style="color:red"><form:errors path="repeatedPassword" /></td>
                                <td style="color:red"><c:out value='${message}'/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" value="${SITE_CONTENT[CREATE]}"/>
                                </td>
                            </tr>
                        </table>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    <%@include file="parts/footer.jsp"%>
    </body>
</html>
