<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class Ingrediente extends Model
{
    public function favsExcs() {
        return $this->belongsToMany(IngredientesFavExc::class);
    }

    public function receitas() {
        return $this->belongsToMany(ReceitasIngrediente::class);
    }
}
