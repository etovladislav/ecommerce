<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">

    <div class="row">

        <div class="col-md-9">

            <div class="thumbnail">
                <img class="img-responsive" src="${product.img}" alt="">
                <hr>
                <div class="caption-full">
                    <h4>Цена: ${product.price} руб.</h4>
                    <hr>
                    <h4>Имя: ${product.name}
                    </h4>
                    <hr>
                    <p style="font-weight: bold;">Описание:</p>
                    <p>${product.description}</p>
                </div>
                <hr>
                <#if auth??>
                    <button class="btn btn-default">Добавить в корзину</button>
                <#else>
                    <a href="/login">Чтобы купить товар войдите в систему</a>
                </#if>
            </div>
        </div>

    </div>

</div>
</#macro>
<@main title="Товар" customStyles=["css/shop-item.css"]/>
