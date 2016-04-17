<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Доставка</h3>
        </div>
        <div class="panel-body">
            <div class="col-md-5">
                <form class="form-signin form-block" role="form" action="/shipping" method="post">
                    <h2 class="form-signin-heading">Информация о доставке</h2>
                    <input type="hidden" name="id" value="${shipping.id}"><br>
                    <input type="text" value="${shipping.fio}" class="form-control" name="fio" placeholder="ФИО"
                           required autofocus><br>
                    <input type="email" value="${shipping.email}" class="form-control" name="email" placeholder="email"
                           required><br>
                    <input type="text" value="${shipping.phone}" class="form-control" name="phone"
                           placeholder="Номер телефона" required><br>
                    <input type="text" value="${shipping.country}" class="form-control" name="country"
                           placeholder="Страна" required><br>
                    <input type="text" value="${shipping.city}" class="form-control" name="city" placeholder="Город"
                           required><br>
                    <input type="text" value="${shipping.street}" class="form-control" name="street" placeholder="Улица"
                           required><br>
                    <input type="text" value="${shipping.house}" class="form-control" name="house" placeholder="Дом"
                           required><br>
                    <button class="btn btn-lg btn-primary btn-block">Ок</button>
                </form>
            </div>
        </div>
    </div>
</div> <!-- /container -->

</#macro>
<@main title="Доставка" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>