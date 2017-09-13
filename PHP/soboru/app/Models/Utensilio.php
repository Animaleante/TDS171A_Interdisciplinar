<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class Utensilio extends Model
{
    public function receitas() {
        return $this->belongsToMany(Receita::class);
    }
}
