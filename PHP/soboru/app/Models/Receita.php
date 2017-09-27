<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class Receita extends Model
{
    public function utensilios() {
        return $this->belongsToMany(Utensilio::class);
    }

    public function user() {
    	return $this->belongsTo(User::class);
    }
    
    /*public function ingredientes() {
        return $this->hasManyThrough(Ingrediente::class, ReceitasIngrediente::class);
    }*/

    public function receitasIngredientes() {
        return $this->hasMany(ReceitasIngrediente::class);
    }

    public function ingredientes() {
        return $this->belongsToMany(Ingrediente::class, 'receitas_ingredientes')
        // ->withTimestamps()
        ->withPivot(['medida_id', 'subsessao', 'qty']);
    }
}
