import {useForm} from 'react-hook-form'
import * as yup from 'yup'
import { yupResolver } from '@hookform/resolvers/yup';
import { useContext, useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import {FetchButton as FetchDisplayButton} from './FetchDisplayButton'
import { MemoryContext } from '../App';
import axios from 'axios'

const postFunction = async(title,description) =>{
    try{
        const response = await axios.post('http://localhost:8080/track/memories' , {title , description} )
        return response.data

    }
    
    catch(err){

        return (err.reponse ? err.response.data : "Error while posting.")

    }
}
export const AddMemory = ({refetch}) =>{

    const {title , setTitle , description ,setDescription} = useContext(MemoryContext)
    const [serverMessage , setServerMessage] = useState("")

    const schema = yup.object().shape({
        title: yup.string().required("Title is required"),
        description :yup.string().required("Description is required")
    })


    const {register , handleSubmit , formState: {errors} , reset} = useForm({
        resolver: yupResolver(schema)
    }
    );
    
    const onSubmit = async(data) =>{
        const response = await postFunction(title,description)
        setServerMessage(response)
        setTitle("")
        setDescription("")
        reset();  
        refetch();
    }

    return (
        <div>
            <form onSubmit = {handleSubmit(onSubmit)}>
               Enter your title: <input type="text" placeholder='Enter your title' {...register("title")} onChange={(event) => {setTitle(event.target.value)}} />
               <p>{title}</p>
               {errors.title && <p>{errors.title.message}</p>}
               <div>
               <label htmlFor='description'>Enter your description: </label>
               </div>
               <textarea name = "descripton" placeholder= "Don't hesitate to write." {...register("description")} 
               onChange={(event) => {setDescription(event.target.value)}}/>
               <p>{description}</p>
               <FetchDisplayButton onClick_post = {handleSubmit(onSubmit)}/>
            </form>
        </div>
    )
}