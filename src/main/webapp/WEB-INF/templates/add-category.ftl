<#include "admin.ftl"/>
<#macro m_body>
<form class="form-horizontal" role="form" action="/admin/add-category" method="post">
    <h2 class="form-signin-heading">Добавить категорию</h2>
    <div class="form-group">
        <label >Имя</label>
        <div class="col-md-5">
            <input type="text" name="name" class="form-control" placeholder="Имя категории" required autofocus>
        </div>
    </div>
    <div class="col-md-5">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Добавить</button>
    </div>
</form>
</#macro>
<@main title="(Админ) Добавить категорию"/>