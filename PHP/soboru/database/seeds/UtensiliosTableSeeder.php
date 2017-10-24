<?php

use Illuminate\Database\Seeder;
use App\Models\Utensilio;

class UtensiliosTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Utensilio::create([
            'nome'=>'Fogão'
        ]);
        Utensilio::create([
            'nome'=>'Forno'
        ]);
        Utensilio::create([
            'nome'=>'Microondas'
        ]);
        Utensilio::create([
            'nome'=>'Geladeira'
        ]);
        Utensilio::create([
            'nome'=>'Batedeira'
        ]);
    }
}
