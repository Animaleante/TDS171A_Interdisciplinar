<div class="form-group">
    <label for="nome">Nome</label>
    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome completo">
</div>

<div class="form-group">
    <label for="login">Login</label>
    <input type="text" class="form-control" id="login" name="login" placeholder="Login">
</div>

<div class="form-group">
    <label for="password">Senha</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Senha">
</div>

<div class="form-group">
    <label for="password_confirmation">Confirme sua Senha</label>
    <input type="password" class="form-control" id="password_confirmation" name="password_confirmation" placeholder="Confirme a Senha">
</div>

<div class="form-group">
    <label for="email">E-mail</label>
    <input type="email" class="form-control" id="email" name="email" placeholder="E-mail">
</div>

{{-- Data de Nascimento --}}
<div class="form-group" style="height: 59px;">
    <label for="nasc">Data de Nascimento</label>
    <input type="text" class="form-control pull-right" id="nasc" name="nasc" placeholder="Data de Nascimento">
</div>

{{-- Select para Role do Usuario --}}
<div class="form-group">
    <label for="role_id">Tipo de usuário</label>
    <div class="radio">
        <label>
            <input type="radio" name="role_id" id="role_id" value="1" checked>
            Usuário
        </label>
    </div>
    <div class="radio">
        <label>
            <input type="radio" name="role_id" id="role_id" value="2">
            Admin
        </label>
    </div>
</div>

{{-- Sexo --}}
<div class="form-group">
    <label for="sexo_id">Sexo</label>
    <select class="form-control" name="sexo_id">
        <option value="1" selected>Feminino</option>
        <option value="2">Masculino</option>
        <option value="3">Indefinido</option>
    </select>
</div>

{{-- Recebe e-mails --}}
<div class="checkbox">
    <label>
        <input type="checkbox" name="notificacao_email" id="notificacao_email"> Receber notificações por e-mail
    </label>
</div>