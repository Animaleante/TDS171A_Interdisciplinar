<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Model;

class Comentario extends Model
{
	/**
	 * primaryKey 
	 * 
	 * @var integer
	 * @access protected
	 */
	protected $primaryKey = null;

	/**
	 * Indicates if the IDs are auto-incrementing.
	 *
	 * @var bool
	 */
	public $incrementing = false;

    public function receita() {
    	return $this->belongsTo(Receita::class);
    }

    public function user() {
    	return $this->belongsTo(User::class);
    }
}
