

<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <form class="form-signin form-block" id="registration-form" role="form" action="/registration" method="post">
        <h2 class="form-signin-heading">Регистрация</h2>
        <input type="login" class="form-control" name="login" id="login" placeholder="Логин" required autofocus>
        <span class="error" id="loginExists">Логин занят</span>
        <input type="password" name="password" id="password" class="form-control" placeholder="Пароль" required>
        <input type="password" name="confirmPassword" id="confirm-password" class="form-control" placeholder="Пароль" required>
        <span class="error" id="passwordNotEqual">Пароли не совпадают</span>
        <button class="btn btn-lg btn-primary btn-block">Регистрация</button>
    </form>
</div> <!-- /container -->

</#macro>
<@main title="Регистрация" customStyles=["css/login.css"] customScripts=["js/registration.js"]/>