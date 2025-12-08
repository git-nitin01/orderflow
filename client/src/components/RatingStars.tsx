
interface RatingStarsProps {
  rating: number;
  max?: number;
}

const MAX_STAR_DEFAULT = 5;

const RatingStars: React.FC<RatingStarsProps> = ({ rating, max=MAX_STAR_DEFAULT }) => {
  const fullStars = Math.floor(rating)
  const hasHalf = rating - fullStars >= 0.5
  const emptyStars = max - fullStars - (hasHalf ? 1 : 0)

  return (
    <div className="flex items-center">
      {Array.from({ length: fullStars }).map((_, idx) => (
        <Star key={`full-${idx}`} variant="full" />
      ))}
      {hasHalf && <Star variant="half" />}
      {Array.from({ length: emptyStars }).map((_, idx) => (
        <Star key={`empty-${idx}`} variant="empty" />
      ))}
      <span className="ml-1 text-xs text-slate-500">
        ({rating})
      </span>
    </div>
  )
}

type StarVariant = "full" | "half"| "empty"

const Star: React.FC<{ variant: StarVariant }> = ({ variant }) => {
  return (
    <span className="inline-flex h-5 w-5">
      <svg
        viewBox="0 0 20 20"
        className="h-5 w-5"
        aria-hidden="true"
      >
        <defs>
          <clipPath id="half-clip">
            <rect x="0" y="0" width="10" height="20" />
          </clipPath>
        </defs>

        <path
          d="M10 2.2l2.12 4.3 4.75.7-3.44 3.35.81 4.73L10 13.9 5.76 15.3l.81-4.73L3.13 7.2l4.75-.7L10 2.2z"
          className={
            variant === "empty"
              ? "fill-slate-200"
              : "fill-slate-200"
          }
        />

        {(variant === "full" || variant === "half") && (
          <path
            d="M10 2.2l2.12 4.3 4.75.7-3.44 3.35.81 4.73L10 13.9 5.76 15.3l.81-4.73L3.13 7.2l4.75-.7L10 2.2z"
            className="fill-amber-400"
            clipPath={variant === "half" ? "url(#half-clip)" : undefined}
          />
        )}
      </svg>
    </span>
  )
}

export default RatingStars