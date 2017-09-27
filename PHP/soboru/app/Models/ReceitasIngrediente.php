<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class ReceitasIngrediente extends Model
{
    public function medida() {
        return $this->belongsTo(MedidasIngrediente::class);
    }
    public function ingrediente() {
        return $this->belongsTo(Ingrediente::class);
    }
}
