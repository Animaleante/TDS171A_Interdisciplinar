<?php

use Illuminate\Database\Seeder;
use App\Models\Ingrediente;

class IngredientesTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Ingrediente::create([
            'nome'=> 'Alho'
        ]);
        Ingrediente::create([
            'nome'=> 'Cebola'
        ]);
        Ingrediente::create([
            'nome'=> 'Bacon'
        ]);
        Ingrediente::create([
            'nome'=> 'Alcatra'
        ]);
    }
}
