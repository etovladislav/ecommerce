<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <#if buckets?has_content>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Проверьте еще раз</h3>
            </div>
            <div class="panel-body">
                <#list buckets as bucket>
                    <h5>
                        Продукт: ${bucket.product.name} <br><br>
                        Итого: ${bucket.product.price * bucket.numberProduct} руб. <br>
                        Количество: ${bucket.numberProduct}
                    </h5>
                    <hr>
                </#list>
                <h3>
                    Общая сумма: ${sum} руб.
                </h3>
                <#if shipping?has_content>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Информация о доставке</h3>
                        </div>
                        <div class="panel-body">
                            Страна: ${shipping.country} <br>
                            Получатель: ${shipping.fio} <br>
                            Город: ${shipping.city} <br>
                            Улица: ${shipping.street} <br>
                            Дом: ${shipping.house} <br>
                        </div>
                    </div>
                    <iframe frameborder="0" allowtransparency="true" scrolling="no"
                            src="https://money.yandex.ru/embed/shop.xml?account=410011953904806&quickpay=shop&payment-type-choice=on&mobile-payment-type-choice=on&writer=seller&targets=%D0%9E%D0%BF%D0%BB%D0%B0%D1%82%D0%B0+%D0%BF%D0%BE%D0%BA%D1%83%D0%BF%D0%BA%D0%B8&targets-hint=&default-sum=${sum}&button-text=01&fio=on&successURL=localhost%3A8080%2Fbuy%2Fproduct%3Fuser_id%3D${auth}"
                            width="450" height="198"></iframe>
                    <form action="/bucket/buyProducts" method="post">
                        <button type="submit">КУПИТь ЕПТА</button>
                    </form>
                <#else>
                    <a href="/settings">Пожалуйста заполните информацию по доставке</a>
                </#if>
            </div>
        </div>
    <#else>
        <h3>Вы еще ничего не добавили в корзину, <a href="/products">перейти к покупкам</a></h3>
    </#if>
</div> <!-- /container -->

</#macro>
<@main title="Корзина" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>