<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class ReceitasIngrediente extends Model
{
    public function ingrediente() {
        return $this->belongsTo(Ingrediente::class);
    }
    
    public function receita() {
        return $this->belongsTo(Receita::class);
    }

    public function medida() {
        return $this->belongsTo(MedidasIngrediente::class);
    }
}
