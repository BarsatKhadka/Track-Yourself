import { useContext, useEffect } from "react"
import { MemoryContext } from "../App"
import { useQuery , useQueryClient } from "@tanstack/react-query"
import axios from "axios"
import { AddMemory } from "./AddMemory"

const getMemories = async() =>{
    try{
        const response =  await axios.get("http://localhost:8080/track/memories")
        return response.data
    }
    catch(err){
        return (err.response ? err.response.data : "An error occured during the fetching process")
    }  
}

export const MemoryList = () =>{

    const {data , isLoading , refetch} = useQuery({queryKey: "memories" , queryFn: getMemories})


    if (isLoading) {
        return <div>Loading...</div>;
      }
      


    return (
        <div>
            <AddMemory refetch = {refetch}/>

            {data.map((memory) =>{
                return (
                    <div>
                        {memory.title}
                        {memory.description}
                    </div>
                )


            })}
            
        
        </div>
    )

}