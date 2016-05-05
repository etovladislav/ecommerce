<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <h3>
        Мои заказы
    </h3>
    <hr>

    <#if orders?has_content>
        <#list orders as order>
            <div class="panel panel-default">
                <div class="panel-body">
                    <a href="/bucket/order/${order.id}">Заказ # ${order.id}</a><br>
                    <p>Статус ${order.orderStatus}</p>
                </div>
            </div>
        </#list>
    <#else>
        <h5>Вы еще не делали заказов</h5>
    </#if>
</div> <!-- /container -->

</#macro>
<@main title="Заказы" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>