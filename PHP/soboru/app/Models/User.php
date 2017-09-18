<?php

namespace App\Models;

use Illuminate\Notifications\Notifiable;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Database\Eloquent\SoftDeletes;
use App\Models\Receita;

class User extends Authenticatable
{
    use Notifiable;
    use SoftDeletes;

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'nome_usuario', 'email', 'password', 'role_id', 'nasc', 'sexo_id', 'notificacao_email',
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password', 'remember_token', 'role_id'
    ];

    /**
     * The attributes that should be mutated to dates.
     *
     * @var array
     */
    protected $dates = ['deleted_at'];

    /*public function sexo() {
        return $this->belongsTo(Sexo::class);
    }*/

    public function role() {
        return $this->belongsTo(Role::class);
    }

    public function receitas() {
        // return $this->belongsToMany(Receita::class);
        return $this->hasMany(Receita::class);
    }

    public function reports() {
        // return $this->belongsToMany(Report::class);
        // return $this->belongsToMany(Receita::class);
        return $this->belongsToMany(Receita::class)->withTimestamps();
    }

    public function pontuacao() {
        return $this->hasMany(PontuacaoReceita::class);
    }

    public function comentarios() {
        return $this->hasMany(Comentario::class);
    }

    public function ingredientes_favoritos() {
        return $this->hasMany(Ingrediente::class, 'ingredientes_fav');
    }

    public function ingredientes_excluidos() {
        return $this->hasMany(Ingrediente::class, 'ingredientes_exc');
    }

    public function receitas_favoritos() {
        return $this->hasMany(Receita::class, 'receitas_fav');
    }

    public function receitas_excluidos() {
        return $this->hasMany(Receita::class, 'receitas_exc');
    }

    /**
     * Criar receita com esse usuario
    */
    public function publish(Receita $receita) {
        $this->receitas()->save($receita);
    }
}
