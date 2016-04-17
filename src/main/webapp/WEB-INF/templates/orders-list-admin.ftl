<#include "admin.ftl"/>
<#macro m_body>
<div class="container">
    <#if orders?has_content>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Заказы</h3>
            </div>
            <div class="panel-body">
                <#list orders as order>
                    <a href="/admin/orders/${order.id}">Заказ номер: ${order.id}</a>
                    <hr>
                </#list>
            </div>
        </div>
    </#if>
</div> <!-- /container -->

</#macro>
<@main title="Заказы" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>