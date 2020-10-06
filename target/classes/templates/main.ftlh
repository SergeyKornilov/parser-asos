<#import "parts/common.ftlh" as a>

<@a.page>

<div class="container">
    <div class="row">
        <div class="col">
            <a href="service">Service page</a>
        </div>
    </div>

    <div class="card-columns">
<#list products as product>
<#--        <div class="row">-->
<#--            <div class="col">-->
        <div class="card my-3">
                <ul>
                    <li><p>id</p>${product.id}</li>
                    <li><p>код товара</p>${product.productCode}</li>
                    <li><p>название</p>${product.name}</li>
                    <li><p>дата добавления</p>${product.dateAdd}</li>
                    <li><p>id категории</p>${product.idCategory}</li>
                    <li><p>ссылка</p>${product.productUrl}</li>
                </ul>
                    <p>картинка</p><img src="${product.urlImg}">

<#--            </div>-->

<#--        </div>-->
        </div>
         <hr align="left" size="3" color="#0000dd" />
</#list>
    </div>
</div>

</@a.page>