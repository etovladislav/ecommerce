<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Доставка</h3>
        </div>
        <div class="panel-body">
            <div class="col-md-5">
                <form class="form-signin form-block"  role="form" action="/shipping" method="post">
                    <h2 class="form-signin-heading">Информация о доставке</h2>
                    <input type="hidden" name="id"><br>
                    <input type="text"  class="form-control" name="fio" placeholder="ФИО" required autofocus><br>
                    <input type="email" class="form-control" name="email" placeholder="email"><br>
                    <input type="text" class="form-control" name="phone" placeholder="Номер телефона"><br>
                    <input type="text" class="form-control" name="country" placeholder="Страна" ><br>
                    <input type="text" class="form-control" name="city" placeholder="Город"><br>
                    <input type="text" class="form-control" name="street" placeholder="Улица"><br>
                    <input type="text" class="form-control" name="house" placeholder="Дом"><br>
                    <button class="btn btn-lg btn-primary btn-block">Ок</button>
                </form>
            </div>
        </div>
    </div>
</div> <!-- /container -->

</#macro>
<@main title="Доставка" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>