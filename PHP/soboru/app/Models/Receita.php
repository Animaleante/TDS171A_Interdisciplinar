<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class Receita extends Model
{
    public function utensilios() {
        return $this->belongsToMany(Utensilios::class);
    }
}