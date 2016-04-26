<#-- @ftlvariable name="totalAmount" type="java.math.BigDecimal" -->
<#-- @ftlvariable name="totalCount" type="java.math.BigDecimal" -->
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "templates/main_template.ftl">
<@mainTemplate title="Мир игрушек" />
<#macro m_body>
<div class="account-in">
    <div class="container">
        <@form.form commandName="orderForm" action="/order" acceptCharset="UTF-8" method="post">
            </br>
            </br>
            </br>
            </br>
            </br>

        <div class="register-top-grid">
            <div id="legend">
                <legend class="">Оформление заказа</legend>
            </div>
        <#--<@form.errors path="*" cssStyle="color: red;" />-->
            <div>
                <span>Область<label>* </label></span>
                <@form.input path="area"/>
                <@form.errors path="area" cssStyle="color: red;" />
            </div>
            <div>
                <span>Город<label>* </label></span>
                <@form.input path="city"/>
                <@form.errors path="city" cssStyle="color: red;" />
            </div>
            <div>
                <span>Улица<label>* </label></span>
                <@form.input path="street"/>
                <@form.errors path="street" cssStyle="color: red;" />
            </div>
            <div>
                <span>Дом<label>* </label></span>
                <@form.input path="house" />
                <@form.errors path="house" cssStyle="color: red;" />
            </div>
            <div>
                <span>Квартира </span>
                <@form.input path="flat" />
                <@form.errors path="flat" cssStyle="color: red;" />
            </div>
            <div>
                <span>Индекс<label>* </label></span>
                <@form.input path="index" />
                <@form.errors path="index" cssStyle="color: red;" />
            </div>
            </br>
            <div>
                <!-- PayWay -->
                <span>Способ оплаты</span>
                <@form.select path ="payWay" style="width: 200px">
                    <option value="Наличные">Наличными при доставке</option>
                    <option value="Карта">Картой при заказе</option>
                </@form.select>
            </div>
            <div>
                <!--Total amount-->
                <#if totalAmount?has_content>
                    <span>Итоговая сумма: ${totalAmount}.00 руб.</span>
                </#if>
            </div>
            <div>
                <!--Total count-->
                <#if totalAmount?has_content>
                    <span>Количество: ${totalCount} шт.</span>
                </#if>
            </div>
            <div class="clearfix"> </div>
            <div class="clearfix"> </div>
            <div class="register-but">
                <a href="/order"><input type="submit" value="Заказать" class="btn btn btn-lg btn-success"></a>
                <div class="clearfix"> </div>
            </div>
        </div>
        </@form.form>
    </div>
    </div>
</#macro>

