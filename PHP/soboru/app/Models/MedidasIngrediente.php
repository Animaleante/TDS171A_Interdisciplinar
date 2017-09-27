<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class MedidasIngrediente extends Model
{
    public function receitasIngredientes() {
        return $this->hasMany(ReceitasIngrediente::class, 'medida_id', 'id');
    }
}
