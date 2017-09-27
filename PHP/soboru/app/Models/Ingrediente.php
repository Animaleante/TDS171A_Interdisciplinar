<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class Ingrediente extends Model
{
    public function favsExcs() {
        return $this->belongsToMany(IngredientesFavExc::class);
    }

    public function receitas() {
        return $this->belongsToMany(Receita::class, 'receitas_ingredientes')
                    // ->withTimestamps()
                    ->withPivot(['medida_id', 'subsessao', 'qty']);
    }
}
