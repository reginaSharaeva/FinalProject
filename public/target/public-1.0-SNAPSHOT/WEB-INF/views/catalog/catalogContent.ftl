<#-- @ftlvariable name="allGoods" type="java.util.List<ru.kpfu.itis.toyshop.domain.Good>" -->
<#-- @ftlvariable name="allGoodsForPage" type="java.util.List<ru.kpfu.itis.toyshop.domain.Good>" -->
<#-- @ftlvariable name="goodInCart" type="boolean" -->
<#-- @ftlvariable name="end" type="Integer" -->
<#-- @ftlvariable name="start" type="Integer" -->
<#-- @ftlvariable name="goodsCount" type="Integer" -->
<#-- @ftlvariable name="categoryId" type="Long" -->
<#if allGoods?has_content>
    <#list allGoods as goods>
    <div class="toy">
        <form action="#">
            <div class="toy-catalog">
                <a href="/good/${goods.id}" class="href-catalog">
                    <img src="/resources/images/${goods.image}" class="toy-search">
                </a>
            </div>
            <a href="/good/${goods.id}" class="href-catalog">${goods.name!} ${goods.color!} ${goods.price!}.00 руб.</a>
        </form>
        <#if goodInCart?has_content>
            <a href="/cart"><input type="submit" value="Перейти в корзину" class="add-tocard-catalog"></a>
        <#else>
            <a href="/cart"><input type="submit" value="Добавить в корзину" class="add-tocard-catalog js_addToCart" data-id="${goods.id}"></a>
        </#if>
    </div>
    </#list>
    <#if end < goodsCount>
    <input type="submit" value="Показать еще" class="btn btn btn-lg btn-success js_showMore" data-id="${categoryId} "data-start="${start+10}" data-end="${end+10}">
    </#if>
<#else>
<p>Нет товаров</p>
</#if>