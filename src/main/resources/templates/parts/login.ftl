<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label  class="col-sm-2 col-form-label"> User Name : </label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Password:</label>
        <div class="col-sm-6">
            <input class="form-control" type="password" name="password" placeholder="Password"/>
        </div>
    </div>
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label"> Email:</label>
        <div class="col-sm-6">
            <input class="form-control" type="email" name="email" placeholder="some@some.com" value="${email!''}"/>
        </div>
    </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
    <button type="submit" class="btn btn-primary"><#if isRegisterForm>Create<#else >Sign in</#if></button>

</form>
</#macro>

<#macro logout>
<form method="post" action="/logout">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary" >Sign out</input>

</form>
</#macro>