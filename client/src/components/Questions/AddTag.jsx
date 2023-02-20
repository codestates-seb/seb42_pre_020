import React, {useState} from 'react'
import Input from '../UI/Input/Input'

const GUIDE = 'Add up to 5 tags to describe what your question is about. Start typing to see suggestions.'

function AddTag({tag, onSubmit}) {
  return (
    <div>
      <h3>Tag</h3>
      <h5>{GUIDE}</h5>
      <Input 
        placeholder='Write Tag'  
        value={tag} 
        onChange={onSubmit} 
      />
    </div>
  )
}


export default AddTag