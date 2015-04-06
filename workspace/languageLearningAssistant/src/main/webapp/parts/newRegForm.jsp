<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="#" class="regForm">
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
</form>