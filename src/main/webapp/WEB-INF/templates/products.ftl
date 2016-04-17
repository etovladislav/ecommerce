<#include "main-template.ftl"/>
<#macro m_body>
    <div class="container product-panel">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">
                <#if categories?has_content>
                    <#list categories as category>
                        <a href="/products?category=${category.id}" class="list-group-item">${category.name}</a>
                    </#list>
                </#if>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row">
                    <div class="col-xs-12" style="margin-bottom: 20px;">
                        <h3>Фильтр:</h3>
                        <select name="filter" class="form-control" id="filter" onchange="filterProduct()">
                            <option value="">Выбрать фильтр</option>
                            <option value="priceUp">По цене ( А - Я )</option>
                            <option value="priceDown">По цене ( Я - А )</option>
                            <option value="nameUp">По имени ( А - Я )</option>
                            <option value="nameDown">По имени ( Я - А )</option>
                        </select>
                    </div>
                    <br>
                    <hr>
                    <br>
                   <#if products?has_content>
                       <#list products as product>
                           <div class="col-sm-4 col-lg-4 col-md-4">
                               <div class="thumbnail">
                                   <div class="caption">
                                       <h4 class="pull-right">${product.price} руб.</h4>
                                       <h4><a href="/products/detail?id=${product.id}">${product.name}</a>
                                       </h4>
                                       <p>${product.description}</p>
                                   </div>
                                   <#if auth??>
                                       <button class="btn btn-default btn-block add-bucket-btn" onclick="addBucket(${product.id})">В корзину</button>
                                   </#if>
                                   <span style="display: none">Товар добавлен</span>
                               </div>
                           </div>
                       </#list>
                   </#if>
                </div>
            </div>
        </div>
    </div>
</#macro>
<@main title="Все продукты" customStyles=["css/shop-homepage.css"] customScripts=["js/bucket.js", "js/filter.js"]/>