<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <form class="form-signin form-block" role="form" action="/login/process" method="post">
        <h2 class="form-signin-heading">Вход</h2>
        <input type="text" name="login" class="form-control" placeholder="Логин" required autofocus>
        <input type="password" name="password" class="form-control" placeholder="Пароль" required>
        <#if error??>
            <span class="error">Неправильный логин или пароль</span>
        </#if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div> <!-- /container -->

</#macro>
<@main title="Вход" customStyles=["css/login.css"]/>