<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<@security.authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
    <@security.authentication property="principal.login" var="auth"/>
    <@security.authentication property="principal.role" var="role"/>
</@security.authorize>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">ТОООРТ</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/products">Торты</a>
                </li>
            <#if auth??>
                <li>
                    <a href="/bucket/all">Корзина</a>
                </li>
                <li>
                    <a href="/settings">Настройки</a>
                </li>
                <li>
                    <a href="/logout">Выйти</a>
                </li>
                <#if role == 'ROLE_ADMIN'>
                    <li>
                        <a href="/admin/index">Админ</a>
                    </li>
                </#if>
            <#else>
                <li>
                    <a href="/login">Вход</a>
                </li>
                <li>
                    <a href="/registration">Регистрация</a>
                </li>
            </#if>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
