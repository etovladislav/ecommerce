<#include "main-template.ftl"/>
<#macro m_body>

<div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron hero-spacer text-center">
        <h1>Магазин тортиков</h1>
        <p>Мы продаем самые вкусные тортики в мире!!</p>
        <p>
            <#if auth??>
                <a href="/products" class="btn btn-primary btn-lg">Все тортики</a>
            <#else >
                <a href="/login" class="btn btn-primary btn-lg">Войти</a>
                <a href="/registration" class="btn btn-success btn-lg">Регистрация</a>
            </#if>

        </p>
    </header>
</div>
</#macro>
<@main title="Привет" customStyles=["css/heroic-features.css"]/>