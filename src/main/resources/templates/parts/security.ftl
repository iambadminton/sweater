<#--Spring-секьюрити  помещает контекст фримаркера в свециальный объект, который позволяет оперировать контекстом-->
<#--спринг-секьюрити-->
<#--операция ?? - приводим к булеву типу-->
<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
<#--если сессия существует, то выполняет некоторые действия-->
<#--далее определяем набор необходимых нам данных-->
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    >
<#else >
    <#assign
    name = "unknown"
    isAdmin = false
    >
<#--отображаем заглушку-->
</#if>