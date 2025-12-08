import { useState, useEffect } from "react"

const apiKey = import.meta.env.VITE_OPEN_CAGE_API
const apiUrl = "https://api.opencagedata.com/geocode/v1/json"

const useCurrentLocation = () => {
  const [userLocation, setUserLocaiton] = useState<{
    city: string,
    state: string,
    postalCode: string,
  }>({
    city: "",
    postalCode: "",
    state: ""
  })

  const [loading, setLoading] = useState<boolean>(true)

  useEffect(() => {
    if(!navigator.geolocation) {
      console.log("Error getting user's current location.")
      setLoading(false);
      return;
    }
    navigator.geolocation.getCurrentPosition(
      async (position) => {
        try {
          const { latitude, longitude } = position.coords
          const locationQuery = await fetch(`${apiUrl}?q=${latitude}+${longitude}&key=${apiKey}`)
          const locationQueryJson = await locationQuery.json()

          if(!locationQueryJson.results || locationQueryJson.results.length === 0) {
            throw new Error("No location results")
          }

          const locationComponents = locationQueryJson.results[0].components
          console.log(locationQueryJson)

          setUserLocaiton({
            city: locationComponents.city || "",
            postalCode: locationComponents.partial_postcode || "",
            state: locationComponents.state_code?.toUpperCase() || ""
          })
        } catch (err) {
          console.log(`some error occured: ${err}`)
        } finally {
          setLoading(false)
        }
      }, 
      (err) => {
        console.log(`some error occured: ${err}`)
        setLoading(false)
      },
      { enableHighAccuracy: true, timeout: 5000 }
    )
  }, [])

  return { ...userLocation, loading }
}

export default useCurrentLocation

