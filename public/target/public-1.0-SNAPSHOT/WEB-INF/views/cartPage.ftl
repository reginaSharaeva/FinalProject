<#-- @ftlvariable name="allCarts" type="java.util.List<ru.kpfu.itis.toyshop.domain.Cart>" -->
<#-- @ftlvariable name="totalAmount" type="java.math.BigDecimal" -->
<#-- @ftlvariable name="totalCount" type="java.lang.Long" -->
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>
<#include "templates/main_template.ftl">
<@mainTemplate title="Мир игрушек" scripts=["js/my/cart.js"]/>
<#macro m_body>
<div id="main-block">
    <h1 class="cart-h">Корзина</h1>
    <a href="/catalog?id=45"><img class="cart-back" src="/resources/images/back.jpg"></a>
    <#if allCarts?has_content>
        <#list allCarts as carts>
            <div class="cart-list">
                <form action="#">
                    <img class="cart-list-img" src="/resources/images/${carts.goods.getImage()!}">
                    <span class="cart-name">${carts.goods.getName()!}</span>
                    <span class="cart-price">${carts.goods.getPrice()!} руб.</span>
                    <a href="/cart"><input class="cart-count btn btn-sm btn-primary js_countLess" type="button" value="-" data-id="${carts.goods.getId()}"></a>
                    <input class="cart-count" form="text" value="${carts.count!}" style="height: 30px; width: 30px"/>
                    <a href="/cart"><input class="cart-count btn btn-sm btn-primary js_countMore" type="button" value="+" data-id="${carts.goods.getId()}"></a>
                    <a href="/cart"><input class="cart-delete-input btn btn-mdl btn-primary js_cartRemove" type="submit" value="Удалить" data-id="${carts.goods.getId()}"></a>
                </form>
            </div>
        </#list>
        <#if totalAmount?has_content>
            <span class="cart-amount">Итого: ${totalAmount}.00 руб.</span>
        </#if>
        <#if totalCount?has_content>
            <span class="cart-amount">Количество: ${totalCount} шт.</span>
        </#if>
        <a href="/order"><input type="submit" value="Оформить заказ" class="cart-order btn-lg btn-success"></a>
    <#else><p>Корзина пуста</p>
    </#if>
</div>
</#macro>


