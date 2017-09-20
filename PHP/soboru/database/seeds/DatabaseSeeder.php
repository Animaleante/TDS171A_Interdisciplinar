<?php

use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $this->call(RolesTableSeeder::class);
        $this->call(UsersTableSeeder::class);
        $this->call(CategoriasTableSeeder::class);
        $this->call(MedidasIngredientesTableSeeder::class);
        $this->call(IngredientesTableSeeder::class);
    }
}
