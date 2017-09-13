<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class ReceitasExc extends Model
{
    public function user() {
        return $this->belongsTo(User::class);
    }

    public function ingrediente() {
        return $this->belongsTo(Ingrediente::class);
    }
}
