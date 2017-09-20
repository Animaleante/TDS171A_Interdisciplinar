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
            'nome_ingrediente'=> 'Alho'
        ]);
        Ingrediente::create([
            'nome_ingrediente'=> 'Cebola'
        ]);
        Ingrediente::create([
            'nome_ingrediente'=> 'Bacon'
        ]);
        Ingrediente::create([
            'nome_ingrediente'=> 'Alcatra'
        ]);
    }
}
