<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateReceitasTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('receitas', function (Blueprint $table) {
            $table->increments('id');
            $table->string('nome_receita')->unique();
            $table->integer('categoria_id');
            $table->integer('user_id');
            $table->string('porcao');
            $table->decimal('tempo_preparo', 5, 2);
            $table->text('modo_preparo');
            $table->string('img_path');
            $table->decimal('pontuacao_media', 5, 2);
            $table->integer('views');
            $table->integer('favs');
            $table->string('slug');
            $table->timestamps();
            $table->softDeletes();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('receitas');
    }
}
